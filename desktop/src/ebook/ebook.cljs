(ns shared.ebook
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<! go]]))

(defn load-ebook [url]
  (go (let [response (<! (http/get url))]
        (if (= (:status response) 200)
          (:body response)
          (throw (js/Error. "Failed to load eBook"))))))

(defn sync-annotations [annotations]
  (go (let [response (<! (http/post "/api/ebook/sync" {:json-params {:annotations annotations}}))]
        (if (= (:status response) 200)
          (:body response)
          (throw (js/Error. "Failed to sync annotations"))))))