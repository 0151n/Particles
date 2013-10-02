Particles
=========


Intro
-----

A basic particle engine written in java using **LWJGL**.

Currently at a very **early stage** don't expect anything *brilliant* for a while.

I am focusing on the *collision* detection for the moment the
collision detection I have in place is pretty terrible but I should 
have that fixed soon.

Compiling and Running
---------------------

Linux
-----
**Scripts** 
If you don't want to run the commands manually you can use the scripts:

*compile_lin.sh*
To compile.

*run_lin.sh*
To run.



**Compilation**

run this at the terminal in the parent directory:

'mkdir bin'

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

**Compilation**

Same as linux instructions.

**Running**

If you get no errors after the compile then you can run the code with
this command in the *bin* directory.

```sh
java -cp ../lib/* -Djava.library.path=../native/windows Engine
```

