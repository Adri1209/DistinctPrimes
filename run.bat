@echo off
"C:\Program Files\Java\jdk1.8.0_162\bin\java" -server -Xms6G -Xmx6G -XX:MaxDirectMemorySize=1024M -XX:NewSize=1G -XX:MaxNewSize=1G -XX:+UseParNewGC -XX:MaxTenuringThreshold=2 -XX:SurvivorRatio=8 -XX:+UnlockDiagnosticVMOptions -XX:ParGCCardsPerStrideChunk=32768 -classpath build\production\PAR\ main.Application
PAUSE