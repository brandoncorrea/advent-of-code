#!/bin/bash

rm -rf addons
mkdir addons
cd addons

# gspec
GSPEC_SHA=6e252863f5085e87a4ba658ae33ada92ef86d39e
GSPEC_ZIP="$GSPEC_SHA.zip"
GSPEC_DIR="gspec-$GSPEC_SHA"
wget "https://github.com/brandoncorrea/gspec/archive/$GSPEC_ZIP"
unzip $GSPEC_ZIP
mv "$GSPEC_DIR/addons/gspec" .
rm $GSPEC_ZIP
rm -rf $GSPEC_DIR
