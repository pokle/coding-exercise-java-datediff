Datediff
========

[![Circle CI Build Status](https://circleci.com/gh/pokle/datediff.png?circle-token=6b4b88a0d80e58c518f0cbdd364e5e279f8c036b)](https://circleci.com/gh/pokle/datediff)
[![Build Status](https://travis-ci.org/pokle/datediff.png)](https://travis-ci.org/pokle/datediff)

This is a coding exercise I once did. It's a tool to calculate the difference between two dates in the Gregorian calendar. And it's capable of handling leap years.

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