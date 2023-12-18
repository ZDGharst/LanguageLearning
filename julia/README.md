# Julia

${toc}

## Why Julia?

- Julia promises the performance of C and the productivity of Python. [Benchmarks](https://julialang.org/benchmarks/)
- Free and open source.
- Easy to learn.
- Extensive standard library.
- Interfaces with other languages, such as C and Python.

## Julia Limitations

- Smaller ecosystem.
- Long compile time.

## Julia REPL

- Julia REPL supports several modes which you can switch between: `?` (help),
  `;` (shell), `[?` (Pkg help), `<backspace>` (julia) and exit with ctrl+p

## Basic Data Types

Julia is dynamically typed with optional type declarations. Variables have the
types of their values. The type system is a hierarchy (`Any` is the root
supertype): Any -> Number -> Real -> Integer -> Bool

```julia
julia> is_available = false
false

julia> typeof(true)
Bool

julia> typeof(is_available)
Bool

julia> is_available = "hello world"
"hello world"

julia> typeof(is_available)
String

julia> supertypes(Bool)
(Bool, Integer, Real, Number, Any)
```

Min and max values can't loop around:

```julia
no_boxes = 50
typeof(no_boxes) # Int64

supertypes(Int65) # (Int64, Signed, Integer, Real, Number, Any)

typemin(Int64) # -9223372036854775808
typemin(Int64) - 1000 # -9223372036854775808
```

Strings can escape characters with `\` per usual. There's also string
concatenation (with `*` instead of `+`). Variables can be used within strings
with `$`.

```julia
$first_name = "Zach"
$last_name = "Gharst"

$full_name = $first_name * " " * $last_name
$full_name = "$first_name $last_name"
```

Tuples...

- ...store a fixed number of items.
- ...can have different types of values.
- ...are immutable.
- ...have an optional delimiter.
- ...are always ordered starting from 1, not 0.

```julia
# different data types
my_tuple = ("Zach Gharst", 'a', 151)

# parens are optional
my_tuple_2 = 'a', "Zach Gharst", 151

# order matters; eval to false
my_tuple == my_tuple_2

# access by index
my_tuple[3]

# unpacking
name, grade, number_pokemon = my_tuple

# immutable; fails to run
my_tuple[3] = 251
```

Arrays...

- ...stores any number of values.
- ...stores only the same types of values.
- ...are mutable.
- ...can have multiple dimensions (vectors, matrices).
- ...must be delimited with [].

```julia
prices = [100, 150, 200, 250]
region_prices = [100 150; 200 250] # 2D array
prices[3] # Get item
prices[2:4] # get a slice of the array
prices[4] = 300
```

Working with dates:

```julia
using Dates

Date(2022)
Date(2023, 12, 15)
Time(9)
Time("10:30:50")

DateTime("2023-12-15T22:30")
DateTime(2023, 12, 15, 22, 30)

event_date = Date(2024, 1, 1)
event_time = Time(10, 30)
event_datetime = DateTime(event_date, event_time)

Dates.month(event_datetime) # 1
```

Composite types allow you to make your own types:

```julia
struct Pokemon
    name::String
    number::Integer
    weight::Float64
end

pikachu = Pokemon("Pikachu", 25, 13.2)
mew = Pokemon("Mew", 151, 8.8)

mutable struct Team
    pokemon_1::Pokemon
    pokemon_2::Pokemon
end

team = Team(pikachu, mew)
```

Operators that would work as expected:

```julia
1 + 2 # 3
3 - 2 # 1
3 * 4 # 12
4 / 2 # 2

awake = true
!awake # false

awake && true # true
awake && false # false

awake || true # true
awake || false # true

5 ≈ 5.0000001 # true
5 ≈ 5.0000010 # false

5 == 5.0 # true
5 === 5.0 # false
```

The dot operator vectorizes the next operator:

```julia
prices = [50.25, 9.99, 4.50]

new_prices = prices .+ 1
```

