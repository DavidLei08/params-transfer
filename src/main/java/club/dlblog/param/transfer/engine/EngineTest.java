package club.dlblog.param.transfer.engine;

public class EngineTest {

    public static  void main(String args[]){
        TransferEngineManger transferEngineManger = new TransferEngineManger();
       String result = transferEngineManger.getEngine("javascript").transfer(
                "{\n" +
                        "    \"code\": 0,\n" +
                        "    \"message\": \"success\",\n" +
                        "    \"timestamp\": 0,\n" +
                        "    \"result\": {\n" +
                        "        \"documents\": [\n" +
                        "            {\n" +
                        "                \"resourceType\": \"r.90.02\",\n" +
                        "                \"resourceName\": \"风险评估\",\n" +
                        "                \"authorId\": \"ai\",\n" +
                        "                \"eventId\": \"57226_21\",\n" +
                        "                \"sections\": [\n" +
                        "                    {\n" +
                        "                        \"resourceCode\": \"AEA05\",\n" +
                        "                        \"resourceName\": \"tables\",\n" +
                        "                        \"title\": \"AI辅助诊断-风险评估\",\n" +
                        "                        \"text\": \"{\\\"result\\\":{\\\"score\\\":0.0,\\\"levelCode\\\":\\\"R001\\\",\\\"level\\\":\\\"低危\\\"},\\\"tableId\\\":\\\"V0001\\\",\\\"content\\\":[{\\\"tableItemName\\\":\\\"计划小手术\\\",\\\"tableItemId\\\":\\\"V0001-002\\\",\\\"source\\\":[{\\\"sourceId\\\":\\\"\\\",\\\"sourceName\\\":\\\"Online\\\"}],\\\"tableItemScore\\\":0.0,\\\"value\\\":[\\\"true\\\"]},{\\\"tableItemName\\\":\\\"下肢水肿\\\",\\\"tableItemId\\\":\\\"V0001-007\\\",\\\"source\\\":[{\\\"sourceId\\\":\\\"\\\",\\\"sourceName\\\":\\\"Online\\\"}],\\\"tableItemScore\\\":0.0,\\\"value\\\":[\\\"true\\\"]}],\\\"tableName\\\":\\\"caprini模型\\\"}\"\n" +
                        "                    }\n" +
                        "                ]\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"versions\": [\n" +
                        "            \"5.0.5201.1025\"\n" +
                        "        ]\n" +
                        "    }\n" +
                        "}","function transfer(json){\n" +
                        "\tvar obj = JSON.parse(json);\n" +
                        "\tvar res = {\n" +
                        "\t\ta:{},\n" +
                        "\t\tb:{},\n" +
                        "\t}\n" +
                        "\tres.a = obj.result;\n" +
                        "\tres.b = obj.message;\n" +
                        "\treturn JSON.stringify(res);\n" +
                        "}"
        );
       System.out.println(result);

    }
}
