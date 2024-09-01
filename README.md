## laptop_repository
 
`git submodule update`

`git submodule deinit -f 追加したサブモジュール`

`git rm -f 追加したサブモジュール`

`rm -rf .git/modules/追加したサブモジュール `

`git pull --recurse-submodules`

`git config submodule.recurse true`

`git submodule update --init`

`git commit -b branchname`

`git pull origin branchname`

`git rm -r --cached repoName`

`git submodule add repoName`


## Sakura

置換前：([^/]+).git$

git submodule add https://github.com/AkimJemi/DreamHotel

置換後：\1.git \1

git submodule add https://github.com/AkimJemi/DreamHotel.git DreamHotel

## Linux Command

Command that counts the number of lines in the output of the git submodule command.

`git status | wc -l`
