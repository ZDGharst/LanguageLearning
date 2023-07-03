# The Rust Programming Language

## Writing and Running a Rust Program

Start with a simple `main.rs` file:

```rust
fn main() {
    println!("Hello world!");
}
```

```
$ rustc main.rs
$ ls
main  main.rs
$ ./main
Hello world!
```

## Using Cargo

Cargo is Rust's package manager and build system. It comes installed with Rust.

```
$ cargo new hello_world
$ cd hello_world
$ cargo build
$ cargo run
```
