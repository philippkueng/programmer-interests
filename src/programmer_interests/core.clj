(ns programmer-interests.core
  (:require [programmer-interests.config :as config]
            [tentacles.core :as core]
            [tentacles.repos :as repos]
            [tentacles.users :as users]
            [tentacles.orgs :as orgs]
            [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.cypher :as cy]))

;; github part

(def auth
  {:auth (str config/username ":" config/password)})

(defn- fetch-members
  "fetch all the users that are members of an organisation"
  [name]
  (orgs/members name auth))

(defn- fetch-user
  "fetch all the details for a given user"
  [name]
  (users/user name auth))


;; neo4j part

(nr/connect! "http://localhost:7474/db/data")


;; fetch all the users
;; fetch all the repositories of that user
;; fetch all the stats about those repositories

;; --- see which users are similar based on the projects they commit to
;; --- see which users are similar based on the languages they use
;; --- see which users are similar based on their stars
;; --- see which users are similar based on the coding habits they use



(cy/tquery "CREATE (p:Person {person})" {:person {:name "Alice"}})

(def members (fetch-members "liip"))

(fetch-user (:login (first members)))
