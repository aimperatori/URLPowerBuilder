package URLBuilder;

public interface IURLBuilder {
    public IURLBuilder SetPath(String path);
    public IURLBuilder SetPort(int port);
    public IURLBuilder AddParameter(String key, String value);
    public IURLBuilder RemoveParameter(String key);
    public String ToString();
}
