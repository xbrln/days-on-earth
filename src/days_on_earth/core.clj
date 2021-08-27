(ns days-on-earth.core
  (:require [clj-time.core :as t]
            [clojure.string :as str]))

(defn calculate
  "Given a date, return the number of days from that date till today.
  Date has to be entered in dd/mm/yyyy format, for example 26/02/1980."
  [date]
  (let [split-date (str/split date #"/")
        day (Integer. (first split-date))
        month (Integer. (second split-date))
        year (Integer. (last split-date))]
    (t/in-days (t/interval (t/date-time year month day) (t/now)))))


(comment
  (calculate "10/02/1980"))
