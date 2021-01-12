# Results

Node's CPU cores: 4

| Request | Limit | Java CPU Cores |
|---------|-------|----------|
| 0.1     | -     | 1        |
| 2       | -     | 2        |
| 2       | 4     | 4        |

Request: spec > containers > resources > request

Limit: spec > containers > resources > limit

Java CPU Cores: `Runtime.getRuntime().availableProcessors()`




