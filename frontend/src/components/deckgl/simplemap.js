import React from 'react'
import DeckGL from '@deck.gl/react';
import { StaticMap } from 'react-map-gl';
import { MapView } from '@deck.gl/core';
import { ScreenGridLayer } from '@deck.gl/aggregation-layers';
import { isWebGL2 } from '@luma.gl/core';

const MAPBOX_ACCESS_TOKEN = 'pk.eyJ1IjoidGlueXplcm8iLCJhIjoiY2szczgyNHduMDMwYjNtcmw2eTA3azA4aSJ9.UnOXmV4S-O6x4CzjrftJWg';

const DATA_URL =
    'https://raw.githubusercontent.com/uber-common/deck.gl-data/master/examples/screen-grid/uber-pickup-locations.json'; // eslint-disable-line

const INITIAL_VIEW_STATE = {
    longitude: -73.75,
    latitude: 40.73,
    zoom: 16,
    maxZoom: 16,
    pitch: 0,
    bearing: 0
};

const colorRange = [
    [255, 255, 178, 25],
    [254, 217, 118, 85],
    [254, 178, 76, 127],
    [253, 141, 60, 170],
    [240, 59, 32, 212],
    [189, 0, 38, 255]
];

// const data = [{ sourcePosition: [-122.41669, 37.7853], targetPosition: [-122.41669, 37.781] }];


class SimpleDeckglMap extends React.Component {
    _renderLayers() {
        const { data = DATA_URL, cellSize = 10, gpuAggregation = true, aggregation = 'Sum' } = this.props;
        return [
            new ScreenGridLayer({
                id: 'grid',
                data,
                getPosition: d => [d[0], d[1]],
                getWeight: d => d[2],
                cellSizePixels: cellSize,
                colorRange,
                gpuAggregation,
                aggregation
            })
        ];
    }

    _onInitialized(gl) {
        if (!isWebGL2(gl)) {
            console.warn('GPU aggregation is not supported'); // eslint-disable-line
            if (this.props.disableGPUAggregation) {
                this.props.disableGPUAggregation();
            }
        }
    }

    render() {
        // const layers = [
        //     new LineLayer({ id: 'line-layer', data })
        // ];
        const {mapStyle = 'mapbox://styles/mapbox/dark-v9'} = this.props;
        return (
            <DeckGL
                initialViewState={INITIAL_VIEW_STATE}
                controller={true}
                layers={this._renderLayers()}
                onWebGLInitialized={this._onInitialized.bind(this)}
            >
                <MapView id="map" height="70%" width="97%" controller={true} >
                    <StaticMap
                        mapboxApiAccessToken={MAPBOX_ACCESS_TOKEN}
                        reuseMaps
                        mapStyle={mapStyle}
                        preventStyleDiffing={true}
                    />
                </MapView>
            </DeckGL>
        );
    }
}

export default SimpleDeckglMap