---
theme: gaia
_class: lead
paginate: true
backgroundColor: #eee
---
# slide generation
## das
	npx @marp-team/marp-cli README.md

---

# JMH
## Java Microbenchmark Harness

---
## Usage

- Generate project by Maven Archetype
	mvn archetype:generate \
	-DinteractiveMode=false \
    -DarchetypeGroupId=org.openjdk.jmh \
    -DarchetypeArtifactId=jmh-java-benchmark-archetype \
    -DgroupId=*org.sample* \
    -DartifactId=*test* \
    -Dversion=1.0
- Edit in IDE
---
- Build by maven
	
		mvn clean install
- Run in terminal

		java -jar target/benchmarks.jar
- or in IDE

		public static void main(String[] args) throws Exception {
	    	org.openjdk.jmh.Main.main(args);
		}
---
## @Benchmark
	@Benchmark
	public void test(){
	}
---

## @BenchmarkMode
	@BenchmarkMode({Mode.Throughput, Mode.SingleShotTime}) 
- Throughput
- AverageTime 
- SampleTime
- SingleShotTime

----
# topics
- JIT optimizing
- JDK12


