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

team.pokemon_1.name

