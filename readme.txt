*********This project serves as only a code sample********
This is part of a project to emulate a basic Fly By Wire system. The code included here is to parse incoming
text based commands and send them to a separate architecture. That architecture is not included as part of this
repository.

While every member contributed to the project, the following is a list of primary responsibility.

Mark Studor (GitHub @mcstudor)
- cmdUnitTests
    - all subfiles
- sbw.project.cli.parser
    - project structure
    - CommandParser
- sbw.project.cli.parser.cmdStrategy
    - CommandChoice interface
    - CommandChooser class
    - Create Command classes
    - Declare Command classes
- test
    - cmds.txt
    - Test class
    - TestAPI class

Valdyn Hunt (GitHub @valdynhunt)
- sbw.project.cli.parser.cmdStrategy
    - Do Command classes
    - Misc Command classes
    - Halt, Commit, and Validate command classes
- test
    - Contributed or created all files

@kingofsky1995
- test
    - Contributed to all files