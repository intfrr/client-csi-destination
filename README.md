```
  start locator --name=locator1 --port=10334
  start server --name=server1 --server-port=40404
  create region --name=customers --type=REPLICATE_PERSISTENT
  configure pdx --disk-store=DEFAULT
```
