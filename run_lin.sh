#!/bin/bash
echo ---running program---
java -cp bin:lib/* -Djava.library.path=native/linux Engine
