SRC_DIR = src/main/java
OUT_DIR = out
SOURCES = $(wildcard $(SRC_DIR)/com/AIProjects/*.java)

all:
	mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) -sourcepath $(SRC_DIR) $(SOURCES)

run:
	java -cp $(OUT_DIR) com.AIProjects.Main
