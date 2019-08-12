(defproject clojure-robot "0.1.0-SNAPSHOT"
  :description "Callum's little robot, written in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot clojure-robot.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
