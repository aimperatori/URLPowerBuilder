package URLBuilder;

import static org.junit.jupiter.api.Assertions.*;

class URLPowerBuilderTest {

    @org.junit.jupiter.api.Test
    void BaseURLWithPathTest() {
        var output = "https://meusite.com.br/user/change-password";

        var builder = new URLPowerBuilder("https://meusite.com.br")
                .SetPath("user/change-password");

        String url = builder.ToString();

        assertEquals(output, url);
    }

    @org.junit.jupiter.api.Test
    public void BaseURLWithPathAndParametersTest() {
        var output = "https://meusite.com.br/user?key1=val1&key2=val2";

        var builder = new URLPowerBuilder("https://meusite.com.br")
                .SetPath("user")
                .AddParameter("key1", "val1")
                .AddParameter("key2", "val2");

        String url = builder.ToString();

        assertEquals(output, url);
    }

    @org.junit.jupiter.api.Test
    public void BaseURLWithPathAndParametersAddedAndRemovedTest() {
        var output = "https://meusite.com.br/user?key2=val2";

        var builder = new URLPowerBuilder("https://meusite.com.br")
                .SetPath("user")
                .AddParameter("key1", "val1")
                .AddParameter("key2", "val2");

        builder.RemoveParameter("key1");

        String url = builder.ToString();

        assertEquals(output, url);
    }

    @org.junit.jupiter.api.Test
    public void RemoveParameterTest() {
        var output = "https://meusite.com.br";

        var builder = new URLPowerBuilder("https://meusite.com.br");

        builder.RemoveParameter("a");

        String url = builder.ToString();

        assertEquals(output, url);
    }

    @org.junit.jupiter.api.Test
    public void RemoveAddedParameterTest()
    {
        var output = "https://meusite.com.br";

        var builder = new URLPowerBuilder("https://meusite.com.br")
                .AddParameter("foo", "bar");

        builder.RemoveParameter("foo");

        String url = builder.ToString();

        assertEquals(output, url);
    }

    @org.junit.jupiter.api.Test
    public void SetTwoTimesPathTest()
    {
        var output = "https://meusite.com.br/user";

        var builder = new URLPowerBuilder("https://meusite.com.br")
                .SetPath("usuario");

        builder.SetPath("user");

        String url = builder.ToString();

        assertEquals(output, url);
    }

    @org.junit.jupiter.api.Test
    public void SetPort()
    {
        var output = "https://meusite.com.br:666";

        var builder = new URLPowerBuilder("https://meusite.com.br/")
                .SetPort(666);

        String url = builder.ToString();

        assertEquals(output, url);
    }

    @org.junit.jupiter.api.Test
    public void SetPortAndPath()
    {
        var output = "https://meusite.com.br:666/user";

        var builder = new URLPowerBuilder("https://meusite.com.br/")
                .SetPath("user")
                .SetPort(666);

        String url = builder.ToString();

        assertEquals(output, url);
    }
}