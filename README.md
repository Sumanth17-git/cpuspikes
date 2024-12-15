http://localhost:8081/spike?duration=50000&threads=8
### Take thread dump from kubernetes 

kubectl exec -n default buggycpu-5b748dc98-dlxvt -- ps aux | grep java

kubectl exec -n default buggycpu-5b748dc98-dlxvt -- jstack 1 > thread_dump.txt
