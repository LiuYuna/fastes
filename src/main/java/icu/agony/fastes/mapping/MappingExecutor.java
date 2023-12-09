package icu.agony.fastes.mapping;

import icu.agony.fastes.builder.Configuration;
import icu.agony.fastes.builder.Connect;
import icu.agony.fastes.builder.MappingStatement;
import okhttp3.*;

import java.io.IOException;

public final class MappingExecutor {

    private final Configuration configuration;

    private final OkHttpClient okHttpClient = new OkHttpClient();

    public MappingExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    public String execute(String statementId) {
        try {
            Connect connect = configuration.getConnect();
            MappingStatement mappingStatement = configuration.getMappingStatementMap().get(statementId);

            String basic = Credentials.basic(connect.getUsername(), connect.getPassword());
            Request request = new Request.Builder().header("Authorization", basic)
                    .url(connect.getUrl() + "/" + mappingStatement.getIndex() + "/" + mappingStatement.getApi())
                    .method(mappingStatement.getMethod(), RequestBody.create(mappingStatement.getRequestBody(), MediaType.get("application/json")))
                    .build();
            Response execute = okHttpClient.newCall(request).execute();
            String body = execute.body().string();
            execute.close();
            return body;
        } catch (Exception e) {
            throw new RuntimeException("执行失败", e);
        }
    }

}
