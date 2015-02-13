(ns four-clojure.core)

(defn fizzbuzz
  [number]
  (cond
    (= 0 (mod number 15)) "fizzbuzz"
    (= 0 (mod number 3)) "fizz"
    (= 0 (mod number 5)) "buzz"
    :else number))


;; 28 Flatten a sequence
(defn my-flatten
  [coll]
  (if (not (sequential? coll))
    [coll]
    (mapcat my-flatten coll)))

;; 31 pack a sequence
(defn pack-seq
  [coll]
  (partition-by identity coll))

;; 39 Interleave Two Seq
(defn interleave-seqs [coll1 coll2]
  (if (or (empty? coll1) (empty? coll2))
    '()
    (cons (first coll1)
          (cons (first coll2)
                (interleave-seqs (rest coll1)
                                  (rest coll2))))))

;; 31 Replicate a Sequence
(defn replicate-seq [coll times-repeated]
  (mapcat #(repeat times-repeated %) coll))

;; 40 Interpose a Seq
(defn interpose-seq [inter coll]
  (if (empty? (rest coll))
    coll
    (cons (first coll)
          (cons inter
                (interpose-seq inter (rest coll))))))




