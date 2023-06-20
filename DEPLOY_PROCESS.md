**I: CONFIGURATION**
- 1: Deploy _ojdbc7.jar_ to wildfly management
- 2: Add datasource: _Configuration -> Datasources & Drivers -> Datasources_
- 3: Rewrite folder from _u01/olamoz_ to _/storage_
  - 3.1: Add handler: _Configuration -> Subsystems -> Web -> Handlers_
  - 3.2: Add location: _Configuration -> Subsystems -> Web -> Server -> default-server -> Hosts -> Local Cache_

**II: CONFIG SYSTEM PROPERTIES**
- 1: Config `base-domain`: `doamin`
- 2: Config `email-host` : `smtp.gmail.com`
- 3: Config `email-port` : `465`
- 4: Config `email-id`   : `no_reply@mct.vn`
- 5: Config `email-pass` : `abc@123`