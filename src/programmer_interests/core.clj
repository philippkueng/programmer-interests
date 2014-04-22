(ns programmer-interests.core
  (:require [programmer-interests.config :as config]
            [tentacles.core :as core]
            [tentacles.repos :as repos]
            [tentacles.users :as users]))

(def auth
  {:auth (str config/username ":" config/password)})
