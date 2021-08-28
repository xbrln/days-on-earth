(ns days-on-earth.core
  (:require [clj-time.core :as t]))

(defn calculate
  "Given a date, return the number of days from that date till today.
  Given a from and to date, return the number of days between them.
  Input parameter is a map with :year, :month and :day as keywords. Example {:year 1980 :month 1 :day 10}
  Keep in mind that singe digit numbers should not be prefixed with 0, since in Java, numbers prefixed with a 0 are treated as octal. So January should be represented as 1 and not 01"
  ([date]
   (calculate date {:year (t/year (t/now))
                    :month (t/month (t/now))
                    :day (t/day (t/now))}))
  ([date-from date-to]
   (t/in-days
     (t/interval
       (t/date-time (:year date-from) (:month date-from) (:day date-from))
       (t/date-time (:year date-to) (:month date-to) (:day date-to))))))

(comment
  ; Usage with one arity
  (calculate {:year 2021 :month 7 :day 26})

  ; Usage with two arities
  (calculate {:year 2021 :month 7 :day 26}
             {:year 2021 :month 7 :day 28}))
