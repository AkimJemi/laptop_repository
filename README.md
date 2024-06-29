# laptop_repository
 

git submodule update
git submodule deinit -f 追加したサブモジュール
git rm -f 追加したサブモジュール
rm -rf .git/modules/追加したサブモジュール 

git pull --recurse-submodules
git config submodule.recurse true
git submodule update --init
glogs
gco -b branchname
gp origin branchname
git rm -r --cached DreamHotel



置換前：([^/]+)$
git submodule add https://github.com/AkimJemi/DreamHotel
置換後：\1.git \1
git submodule add https://github.com/AkimJemi/DreamHotel.git DreamHotel