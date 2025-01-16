(ns shared.ui
  (:require [reagent.core :as r]))

(defn header []
  [:div.header
   [:h1 "Online Classroom App"]])

(defn footer []
  [:div.footer
   [:p "© 2023 Online Classroom App"]])