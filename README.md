Datediff
========

[![Build Status](https://travis-ci.org/pokle/coding-exercise-java-datediff.svg?branch=master)](https://travis-ci.org/pokle/coding-exercise-java-datediff)

This is a coding exercise I once did. It's a tool to calculate the difference between two dates in the Gregorian calendar. And it's capable of handling leap years.

Yes you can use some excellent libraries such as joda time to achieve the same, but this coding exercise asked me not to use them. It was an interesting experience reading up on the Gregorian calendar (thanks Wikipedia!), and really understanding leap years. Thankfully I've forgotten all the details now!

Here's how you run it, and some sample output: (You'll need gradle)

    $ gradle installApp

    $ ./build/install/datediff/bin/datediff  < sample1.csv
    01 01 2011, 02 01 2011, 1
	13 11 2011, 11 11 2011, 2
	13 11 2011, 12 11 2011, 1
	13 11 2011, 13 11 2011, 0
	13 11 2011, 14 11 2011, 1
	13 11 2011, 15 11 2011, 2
	01 01 2000, 01 01 2010, 3652


Cheers!
Tushar
