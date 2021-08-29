(ns days-on-earth.core
  (:require [clj-time.core :as t]
            [clj-time.format :as f]))

(defn calculate
  "Given a date, return the number of days from that date till today.
  Given a from and to date, return the number of days between them.
  Input parameter is a map with :year, :month and :day as keywords. Example {:year 1980 :month 1 :day 10}
  Single digit numbers should not be prefixed with 0, since in Java, numbers prefixed with a 0 are treated as octal. So January should be represented as 1 and not 01"
  ([date]
   (calculate date {:year (t/year (t/now))
                    :month (t/month (t/now))
                    :day (t/day (t/now))}))
  ([date-from date-to]
   (t/in-days
    (t/interval
     (t/date-time (:year date-from) (:month date-from) (:day date-from))
     (t/date-time (:year date-to) (:month date-to) (:day date-to))))))

(defn forecast-date
  "Get the forecast date for the milestone from the given date.
  Date is a map with :year, :month and :day as keywords.
  Milestone is an integer."
  [date milestone]
  (f/unparse
   (f/formatters :date)
   (t/plus
    (t/date-time (:year date) (:month date) (:day date))
    (t/days milestone))))

(defn forecast
  "Get the forcast for the given date, milestone and limit
  Date is a map with :year, :month and :day as keywords.
  Milestone and limit are integers."
  [date milestone limit]
  (loop [f []
         r (take limit (rest (filter #(zero? (mod % milestone)) (range))))]
    (if (not-empty r)
      (recur
       (conj f [:milestone (first r)
                :date (forecast-date date (first r))
                :age (int (/ (first r) 365.25))])
       (rest r))
      f)))

(comment
  ; Usage with one arity
  (calculate {:year 1980 :month 8 :day 26})

  ; Usage with two arities
  (calculate {:year 2021 :month 7 :day 26}
             {:year 2021 :month 7 :day 28})

  ; Get forcast with 100 as milestone and limit as 35
  (forecast {:year 1980 :month 8 :day 26} 1000 35))
