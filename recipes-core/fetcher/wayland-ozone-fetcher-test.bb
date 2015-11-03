DESCRIPTION = "Test for gclient sync"

LICENSE = "MIT"
SRC_URI="\
  gclient://github.com/01org/ozone-wayland.git;project-name=src/ozone;deps-file=.DEPS.git  \
"


LIC_FILES_CHKSUM = "file://LICENSE;md5=0fca02217a5d49a14dfe2d11837bb34d"

S="${WORKDIR}/gclient/src"
do_configure(){
  echo "Configure a big nothing."
}

do_qa_configure() {
  echo "Wasting some CPU cycles."
}

do_compile() {
 echo "Do nothing."
}

do_install() {
 echo "We now install all the hardly generated nothing."
}

OZONE_WAYLAND_PATCH_FILE_GLOB = "*.patch"
OZONE_WAYLAND_EXTRA_PATCHES = ""

do_patch[prefuncs] += "add_ozone_wayland_patches"
 
python add_ozone_wayland_patches() {
    import glob
    srcdir = d.getVar('S', True)
    # find all ozone-wayland patches and add them to SRC_URI
    upstream_patches_dir = srcdir + "/ozone/patches"
    upstream_patches = glob.glob(upstream_patches_dir + "/" + d.getVar('OZONE_WAYLAND_PATCH_FILE_GLOB', True))
    upstream_patches.sort()
    for upstream_patch in upstream_patches:
        d.appendVar('SRC_URI', ' file://' + upstream_patch)
    # then, add the extra patches to SRC_URI order matters;
    # extra patches may depend on the base ozone-wayland ones
    d.appendVar('SRC_URI', ' ' + d.getVar('OZONE_WAYLAND_EXTRA_PATCHES'))
}

