(ns shared.communication
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<! go]]))

(defn start-video-call [peer-id]
  (go (let [response (<! (http/post "/api/video/start" {:json-params {:peer-id peer-id}}))]
        (if (= (:status response) 200)
          (:body response)
          (throw (js/Error. "Failed to start video call"))))))

(defn send-message [message]
  (go (let [response (<! (http/post "/api/message/send" {:json-params {:message message}}))]
        (if (= (:status response) 200)
          (:body response)
          (throw (js/Error. "Failed to send message"))))))