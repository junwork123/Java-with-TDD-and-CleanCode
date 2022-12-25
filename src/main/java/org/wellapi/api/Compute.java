package org.wellapi.api;

import java.util.List;
import java.util.Map;

public interface Compute {
    public void computeData(Request request, Response response);

    public final class Request { /** 접근자만 허용한다. **/
        private final String requestUrl;
        private final Map<String, Object> requestParams;

        Request(String requestUrl, Map<String, Object> requestParams) {
            this.requestUrl = requestUrl;
            this.requestParams = requestParams;
        }
        public String getRequestUrl() {
            return requestUrl;
        }
        public Object getParam(String key) {
            return requestParams.get(key);
        }
    }
    public final class Response { /** 설정자만 허용한다. **/
        private final Map<String, String> result;
        Response(Map<String, String> result){
            this.result = result;
        }

        public void add(String s){
            result.put(s, s);
        }

        public void addAll(List<String> list){
            for(String item : list){
                add(item);
            }
        }

        /** @since 2.0 **/
        public void add(String s, String description){
            result.put(s, description);
        }
    }
}
