Particles
=========


Intro
-----

A basic particle game written in java using **LWJGL**.

Currently at a very **early stage** don't expect anything *brilliant* for a while.

I am focusing on the *collision detection* for the moment the
collision detection I have in place is pretty terrible but I should 
have that fixed soon.

Dependencies
------------
To build and run this project you'll need the 
*Java jdk* and the *Java jre*.

Compiling and Running
---------------------

Linux
-----
**Scripts** 

If you don't want to run the commands manually you can use the scripts:

To compile: *compile_lin.sh*


To run: *run_lin.sh*




**Compilation**

run this at the terminal in the parent directory:

```sh
mkdir bin
```

Then
```sh
javac -cp .:lib/* src/*.java -d bin
```
**Running**

I you get no errors after the compile then you can run the code with this
command in the *bin* directory.

```sh
java -cp ../lib/* -Djava.library.path=../native/linux Engine
```

Windows
-------

**Scripts**

To compile: *compile_win.bat*

To run: *run_win.bat*


**Compilation**

Same as Linux instructions.

**Running**

If you get no errors after the compile then you can run the code with
this command in the *bin* directory.

```sh
java -cp ../lib/* -Djava.library.path=../native/windows Engine
```

