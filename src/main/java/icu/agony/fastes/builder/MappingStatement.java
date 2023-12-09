package icu.agony.fastes.builder;

public class MappingStatement {

    private String id;

    private String index;

    private String method;

    private String api;

    private String requestBody;

    public MappingStatement(String id, String index, String method, String api, String requestBody) {
        this.id = id;
        this.index = index;
        this.method = method;
        this.api = api;
        this.requestBody = requestBody;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
