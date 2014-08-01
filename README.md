# hadoop-udf

small collection of random hadoop UDFs, don't expect miracle, just few handy snippets

## Version
1.0


## Functions

### sha1
simple UDF for applying SHA1 + BASE64 on a string

```sql
ADD JAR hive-crypto-udfs-1.0.jar;
CREATE TEMPORARY FUNCTION sha1 as 'io.jackass.hadoop.hive.udf.crypto.sha1';
select sha1('1111') from your_table;
```
 

I appolgize for not mavenize it yet, here is old school javac using classpath pointing to local CDH 4.2.1

```bash
CP=$(find "/opt/cloudera/parcels/CDH/lib" -name '*.jar' -printf '%p:' | sed 's/:$//')
javac -classpath $CP io/jackass/hadoop/hive/udf/crypto/sha1.java
jar -cf hive-crypto-udfs-1.0.jar  -C . .
```


## License
MIT


**Free Software, Hell Yeah!**
