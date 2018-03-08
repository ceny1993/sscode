#!/bin/bash
gitRootDir='/Users/chensongkui/IdeaProjects/'
resultFile=$gitRootDir"time_of_2017"
cat /dev/null > $resultFile
cd $gitRootDir
for file in ./*
do
    if test -d $file
    then
	cd $file
        echo $file
	echo $file >> $resultFile
	git log --pretty=format:"%at %an %H %s" | grep -E 'chensongkui|陈松奎' | grep -Ev 'Merge (pull|branch|remote)' | awk '{cmd="git show " $3;system(cmd)}' | grep -Ev '[\+\-]{3}' | grep -E '^[\+\-]' | awk 'BEGIN {addCode=0;delCode=0} {if(index($0, "+")==1) addCode++; else delCode++} END{printf("### add %d delete %d\n", addCode, delCode)}' >> $resultFile
	echo ''
	echo '' >> $resultFile
	cd ../
    fi
done
cat $resultFile | grep '###' | awk 'BEGIN{addCode=0;delCode=0} {addCode+=$3;delCode+=$5} END{printf("add %d lines, delete %d lines.\n", addCode, delCode)}' >> $resultFile
tail -n 1 $resultFile
