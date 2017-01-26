# Preventors

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

[Preventors Bukkit Plugin Page] (https://dev.bukkit.org/projects/preventors)

Preventors is a plugin based around preventing people from using certain events. I will be adding more events soon enough. Currently it only has preventing pickupItemEvents and dropItemEvents. You may choose what items you want to prevent from each event in the config through the config lists. You also may configure the messages for these events if they are prevented.

<h2>Commands</h2>
None yet.

<h2>Permissions</h2>
None yet.

<h2>Example Config</h2>
```YAML
Lists:
  PreventDropsOf:
                - IRON_SWORD
                - STONE_SWORD
                - WOOD_SWORD
  PreventPickupsOf:
                  - DIAMOND_SWORD
                  - IRON_SWORD
                  - STONE_SWORD
                  - WOOD_SWORD
Messages:
  PreventDropMessage: '&cYou may not drop this item!'
  PreventPickupsMessage: '&cYou may not pickup this item!'
```

<h2>Future Plans</h2>
I have future plans to upgrade this plugin further and further to give you the most functionality possible!
