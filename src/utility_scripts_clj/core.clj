(ns utility-scripts-clj.core
  (:gen-class)
  (:import java.io.File))

(defn delete-temp-files 
  "Deletes all the temporary files in a given path and its subdirectories.
path should be a valid java.io.File object."
  [path]
  (let [dir (file-seq path)
        is-temp-file (fn [file-name] (and (. file-name isFile) (.endsWith (.getName file-name) "~")))]
    (map (memfn delete) (filter is-temp-file dir))))

(defn -main
  "Takes a pathname and calls delete-temp-files on it."
  [path]
  (delete-temp-files (File. path)))
