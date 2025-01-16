(ns shared.classroom
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<! go]]))

(defn create-classroom [name]
  (go (let [response (<! (http/post "/api/classroom/create" {:json-params {:name name}}))]
        (if (= (:status response) 200)
          (:body response)
          (throw (js/Error. "Failed to create classroom"))))))

(defn join-classroom [code]
  (go (let [response (<! (http/post "/api/classroom/join" {:json-params {:code code}}))]
        (if (= (:status response) 200)
          (:body response)
          (throw (js/Error. "Failed to join classroom"))))))