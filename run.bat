"%JAVA%\bin\java" -server -Xms2G -Xmx2G -XX:MaxDirectMemorySize=1024M -XX:NewSize=1G -XX:MaxNewSize=1G -XX:+UseParNewGC -XX:MaxTenuringThreshold=2 -XX:SurvivorRatio=8 -XX:+UnlockDiagnosticVMOptions -XX:ParGCCardsPerStrideChunk=32768 -classpath target\production\Sem4_se_par Application
pause