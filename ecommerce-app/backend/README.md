<!-- @format -->

# Starting the Backend

The Repo comprises of two docker compose files, one for ARM architecture and another for AMD architecture. Please use the appropriate one based on your system.

To start the backend, run the following command in the terminal:

```bash
docker compose -f docker-compose-amd.yml up
```

to start the backend on AMD architecture,

or

```bash
docker compose up
```

to start the backend on ARM architecture, which is the default docker compose file.
