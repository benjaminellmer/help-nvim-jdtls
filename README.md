# Help nvim-jdtls

This is a small setup including multiple spring boot projects within a single gradle project.
The repository was created for debugging my `nvim-jdlts` configuration, which shows very strange behaviour with the given setup.
- Usually jdtls is not able to resolve the generated classes and the LSP is complaining about `missing types` and no LSP features are working
- Sometimes jdtls is not able to resolve the generated classes and the LSP is complaining about `missing types`, but `vim.lsp.buf.definition` is somehow working
- Once during the setup of this project I suddenly ran into a state where everything was working --- sadly, I don't know how I achieved this and was not able to reproduce it after clearing the caches

The `api-spec` directory includes an api specification, which is used to generate controller stubs for the server.
Furthermore, the api specification is used to generate feign clients for the client.

The server has only one single functionality, which is returning a static list of Persons including Alice and Bob.
The client is a `CommandLineRunner` that simply fetches and prints the persons.

## Run server
To run the server execute the following command at the root directory of the repository:
```
./gradlew server:bootRun
```

## Run Client
To run the client execute the following command (while the server is running) at the root directory of the repository:
```
./gradlew client:bootRun
```
