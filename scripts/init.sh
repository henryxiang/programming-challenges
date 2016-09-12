#!/bin/bash

ID=$1

cd `dirname $0`/..

mkdir -p $ID/{java,cpp}
echo "* [$ID](./$ID)" >> README.md
echo "## [$ID]()" > $ID/README.md
touch $ID/{input,output}.txt
