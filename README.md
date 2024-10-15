
# FUID 工程

## 功能
- [x] 雪花算法
- [x] NanoId
- [x] Hashids

## 使用

### 引入依赖
```xml
<dependency>
    <groupId>com.ijunfu.id</groupId>
    <artifactId>fu-id-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 雪花算法

#### 自定义配置
```yaml
fu:
  snowflake:
   enabled: true # 启用雪花算法，默认关闭
   workerId: 1 # 机器ID，默认值为1
   dataCenterId: 1 # 数据中心ID，默认值为1
```

#### 测试

```java
@Slf4j
@SpringBootTest
class SnowflakeConfigurationTest {

    @Autowired
    private SnowflakeId snowflakeId;

    @Test
    @DisplayName("雪花算法")
    void snowflakeId() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        IntStream.range(0,100).forEach(i -> {
            log.info("{}", snowflakeId.nextId());
        });

        stopWatch.stop();
        log.info("totalTime={}ms", stopWatch.getTotalTimeMillis());
    }
}
```

### NanoId

#### 自定义配置
```yaml
fu:
  nano:
    enabled: true # 启用 NanoId算法，默认关闭
    size: 21 # 生成ID长度，默认值为21
    alphabet: 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_ # 字符集，用于生成ID
```
#### 测试

```java
@Slf4j
@SpringBootTest
public class NanoConfigurationTest {

    @Resource
    private NanoId nanoId;

    @Test
    @DisplayName("Nano ID")
    void nextId() {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        IntStream.range(0,100).forEach(i -> {
            log.info("{}", nanoId.nextId());
        });
        stopWatch.stop();

        log.info("{}ms", stopWatch.getTotalTimeMillis());
    }
}
```

### Hashids

#### 自定义配置
```yaml
fu:
  hashids:
    enabled: true # 启用 HashIds算法，默认关闭
    alphabet: 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ # 字符集，用于生成ID
    salt: ijunfu # 盐值，用于生成ID
```

#### 测试
```java
@SpringBootTest
public class HashidsConfigurationTest {

    @Resource
    private Hashids hashids;

    @DisplayName("Hashids")
    @Test
    void hashids() {
        long id = 1845896192316280832L;

        String encoded = hashids.encode(id);
        Assertions.assertNotNull(encoded);

        long[] decoded = hashids.decode(encoded);
        Assertions.assertEquals(1, decoded.length);

        Assertions.assertEquals(id, decoded[0]);
    }

}
```