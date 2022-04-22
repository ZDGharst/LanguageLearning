# PowerShell

PowerShell is a modern command shell that accepts and returns .NET objects (not
just other text like other shells). It supports tab completion, command history,
aliases, pipelining, and `man` pages.

PowerShell is commonly used as a scripting language to automate the management
of systems -- building, testing, deploying solutionsin CI/CD environments. It is
built on top of the CLR (.NET Common Language Runtime). Because all
inputs/outputs are .NET objects, there is no need to parse text input. It's
extensible through functions, classes, and modules, and it has a formatting
system for easy output. It also has built-in support for data formats such as
CSV, JSON, and XML.

## Checking PowerShell Version

PowerShell stores state information in variables. One of those variables is
`$PSVersionTable` which is a hashtable of versioning for PowerShell and its
dependencies. 

## Execution Policy

By default, PowerShell runs on a restricted policy. You can get the current
policy with the command `RemoteSigned` and change policy with
`Set-ExecutionPolicy -ExecutionPolicy RemoteSigned`. 

## The Three Core Cmdlets in PowerShell

It isn't important to know commands off the top of your head. It's important to
know how to find what you need to do.

- `-Get-Command`
- `Get-Help`
- `Get-Member`

Use these cmdlets to search for other commands and how to use them. For
example...

```
Get-Command -Name *service* -CommandType Cmdlet, Function, Alias
```

This command will search the system for any commands with service
(case-insensitive and wildcards on each side) and limit it to only those of a
certain type. Only PowerShell commands have both verbs and nouns if one wishes to filter on
those, in order to avoid returning exes.

What about `Get-Member`? `Get-Member` will return all of the properties and
methods of objects.

```
Get-Service -Name w32time | Get-Member
```

This will display output with the typename and all the members it contains.
Using the type you just learned, you can find other commands with that type,
too:

```
Get-Command -ParameterType ServiceController
```

## Select-Object

`Select-Object` projects out only certain fields.

```
Get-Service -Name w32time | Select-Object -Property Status, DisplayName, Can*
```

This will display `Status`, `DisplayName`, `CanPauseAndContinue`, `CanShutdown`,
and `CanStop` of the w32time service.

## Methods

Methods are an action that can be taken. `(Get-Service -Name w32time).Stop()`
will stop the w32time service. Though, prefer using a cmdlet to perform the
action if one exists. So instead, `Get-Service -Name w32time | Start-Service
-PassThru` is a better idea.

## Variables

A variable can be declared with `$Users = Get-ADUser -Identity zach -Properties
*`. You could pipe variables just as before: `$Users | Get-Member`, which in
this case can save on an Active Directory query. 

## Continue Learing

Learn a PowerShell command every day! `Get-Command | Get-Random | Get-Help
-Full`

