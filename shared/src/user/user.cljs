(ns shared.user
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<! go]]))

(defn login [username password]
  (go (let [response (<! (http/post "/api/login" {:json-params {:username username :password password}}))]
        (if (= (:status response) 200)
          (:body response)
          (throw (js/Error. "Login failed"))))))

(defn register [username password email]
  (go (let [response (<! (http/post "/api/register" {:json-params {:username username :password password :email email}}))]
        (if (= (:status response) 200)
          (:body response)
          (throw (js/Error. "Registration failed"))))))