SRC_URI="gclient://github.com/kuscsik/meta-testing;branch=master;protocol=git;project_name=testing"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://meta-testing/LICENSE;md5=86c191adbfb397761195dfe486ee632c"
S="${WORKDIR}/gclient"
do_configure(){
  echo "Configure a big nothing."
}

do_compile() {
 echo "Do nothing."
}

do_install() {
 echo "We now install all the hardly generated nothing."
}
