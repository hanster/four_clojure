(ns four-clojure.core-spec
  (:require [speclj.core :refer :all]
            [four-clojure.core :refer :all]))

(describe "Fizz Buzz tests"
          (it "returns numbers"
              (should= 1 (fizzbuzz 1)))
          (it "returns 'fizz' when divisible by 3"
              (should= "fizz" (fizzbuzz 3)))
          (it "returns 'buzz' when divisible by 5"
              (should= "buzz" (fizzbuzz 5)))
          (it "returns fizzbuzz when divisiible by 15"
              (should= "fizzbuzz" (fizzbuzz 15))))

(describe "Flatten tests"
          (it "handles 1 item sequence"
              (should= '(1) (my-flatten '(1))))
          (it "handles 2 item sequence"
              (should= '(1 2) (my-flatten '(1 2))))
          (it "a sequence with 2 sequences of 1"
              (should= '(1 2 3) (my-flatten '((1) (2 3)))))
          (it "first test in 4clj"
              (should= '(1 2 3 4 5 6) (my-flatten '((1 2) 3 [4 [5 6]])))))

(describe "Pack a sequence"
          (it "groups consecutive duplicates"
              (should= '((1 1) (2 2)) (pack-seq '(1 1 2 2)))))

(describe "Interleave Two Seqs"
          (it "interleaves two same size seqs"
              (should= '(1 :a) (interleave-seqs [1] [:a]))
              (should= '(1 :a 2 :b 3 :c) (interleave-seqs [1 2 3] [:a :b :c])))
          (it "interleaves diff size seqs, stopping at the shortest one"
              (should= '(1 3 2 4) (interleave-seqs  [1 2] [3 4 5 6]))))

(describe "Replicate a Sequence"
          (it "returns the same list from a collection"
              (should= '(4 5 6) (replicate-seq [4 5 6] 1)))
          (it "returns a the list replicated twice"
              (should= '(1 1 2 2 3 3) (replicate-seq [1 2 3] 2)))
          (it "replicated a list of vectors"
              (should= '([1 2] [1 2] [3 4] [3 4]) (replicate-seq [[1 2] [3 4]] 2))))

(describe "Interpose a sequence"
          (it "returns the same item if a single list"
              (should= [1] (interpose-seq 0 [1])))
          (it "returns interposed seq when 2 items in the seq"
              (should= [1 0 2] (interpose-seq 0 [1 2])))
          (it "returns larger interposed seq"
              (should= [:a :z :b :z :c :z :d] (interpose-seq :z [:a :b :c :d]))))
