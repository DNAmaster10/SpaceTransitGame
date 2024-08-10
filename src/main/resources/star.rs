#version 330

// Input vertex attributes (from vertex shader)
in vec2 fragTexCoord;    // Texture coordinates from the vertex shader
in vec4 fragColor;       // Color from the vertex shader

// Input uniform values
uniform sampler2D texture0; // The texture sampler
uniform vec4 colDiffuse;    // The diffuse color multiplier

// Output fragment color
out vec4 finalColor;        // The final output color of the fragment

// NOTE: Add here your custom variables
uniform vec3 starColor;

float d;
vec3 circle;

void main() {
    circle = vec3(0.5, 0.5, 0.4);
    d = length(fragTexCoord - circle.xy) - circle.z;
    d = smoothstep(0., 0.1, d);
    d = 1. - d;
    //d = smoothstep(0., 0.2, d);

    finalColor = vec4(starColor.x, starColor.y, starColor.z, d);
}
