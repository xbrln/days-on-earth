# days-on-earth

A Clojure library designed to calculate the number of days you have lived on earth!

## Usage


- Add to your leiningen dependencies in project.clj
`[xbrln/days-on-earth "0.1.0"]`
- Require in your code `[days-on-earth.core :as doe]`
- Example
  `Usage with one arity
  (doe/calculate {:year 2021 :month 7 :day 26})

  ; Usage with two arities
  (doe/calculate {:year 2021 :month 7 :day 26}
             {:year 2021 :month 7 :day 28})`

## License

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
