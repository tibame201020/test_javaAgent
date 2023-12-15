## test JavaAgent and use bytebuddy
```
package beAgentApp by maven
```
```
package agentApp by maven
```
```
java -javaagent:${agentAppJar} -jar ${beAgentAppJar}
```
