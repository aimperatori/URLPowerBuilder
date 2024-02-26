package URLBuilder;

import URLBuilder.Helper.StringBuilderHelper;

import java.util.Hashtable;

public class URLPowerBuilder implements IURLBuilder {

    private final String authority;
    private StringBuilder urlBuilder;
    private String path;
    private int port;
    private final Hashtable<String, String> parameters;

    public URLPowerBuilder(String _authority) {
        authority = _authority;
        urlBuilder = new StringBuilder();
        parameters = new Hashtable<>();
    }

    @Override
    public IURLBuilder SetPath(String _path) {
        path = _path;
        return this;
    }

    @Override
    public IURLBuilder SetPort(int _port) {
        port = _port;
        return this;
    }

    @Override
    public IURLBuilder AddParameter(String _key, String _value) {
        parameters.put(_key, _value);
        return this;
    }

    @Override
    public IURLBuilder RemoveParameter(String _key) {
        parameters.remove(_key);
        return this;
    }

    @Override
    public String ToString() {

        ClearUrl();

        AppendAuthority();
        
        AppendPort();
        
        AppendPath();
        
        AppendParameters();

        return urlBuilder.toString();
    }

    private void ClearUrl() {
        urlBuilder.setLength(0);
    }

    private void AppendAuthority() {
        urlBuilder.append(authority);
    }

    private void AppendPort() {
        if (port > 0)
        {
            urlBuilder = StringBuilderHelper.TrimEnd(urlBuilder, '/');

            urlBuilder.append(":");
            urlBuilder.append(port);
        }
    }

    private void AppendPath() {
        if (path != null)
        {
            urlBuilder = StringBuilderHelper.TrimEnd(urlBuilder, '/');

            urlBuilder.append('/');
            urlBuilder.append(path);
        }
    }

    private void AppendParameters() {
        if (!parameters.isEmpty()) {
            urlBuilder.append(FormatParameters());
        }
    }

    private String FormatParameters() {
        StringBuilder parmBuilder = new StringBuilder();

        parmBuilder.append('?');

        parameters.forEach((key, value) -> {
            parmBuilder.append(key);
            parmBuilder.append('=');
            parmBuilder.append(value);
            parmBuilder.append('&');
        });

        parmBuilder.deleteCharAt(parmBuilder.length()-1);

        return parmBuilder.toString();
    }
}
